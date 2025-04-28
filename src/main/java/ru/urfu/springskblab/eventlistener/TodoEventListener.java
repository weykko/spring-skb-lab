package ru.urfu.springskblab.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.urfu.springskblab.eventlistener.event.DatabaseChangedEvent;
import ru.urfu.springskblab.eventlistener.event.GetTodoEvent;
import ru.urfu.springskblab.eventlistener.event.MessageSendEvent;

import java.util.Objects;

@Slf4j
@Component
public class TodoEventListener {

    @EventListener
    public void handleMessageReceivedEvent(GetTodoEvent event) {
        if (Objects.equals(event.id(), "ALL")) {
            log.info("Получены все TODO листы");
        }
        else {
            log.info("Получен TODO лист с id {}", event.id());
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleDatabaseChangedEvent(DatabaseChangedEvent event) {
        log.info("Внесены изменения в базу данных в таблице todo_lists для записи с id {}", event.id());
    }

    @Async
    @EventListener
    public void handleMessageSendEvent(MessageSendEvent event) throws InterruptedException {
        log.info("Отправка пользователю сообщение о создании нового TODO листа c именем {}", event.name());

        // Отправляем сообщение...
        Thread.sleep(1000);
        log.info("Сообщение отправлено");
    }
}
