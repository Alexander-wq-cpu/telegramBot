package ru.relex.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.relex.controller.UpdateProcessor;
import ru.relex.service.AnswerConsumer;

import static ru.relex.model.RabbitQueue.ANSWER_MESSAGE;

@Service
public class AnswerConsumerImpl implements AnswerConsumer {
    private final UpdateProcessor updateProcessor;

    @Autowired
    public AnswerConsumerImpl(UpdateProcessor updateProcessor) {
        this.updateProcessor = updateProcessor;
    }

    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
        updateProcessor.setView(sendMessage);
    }
}
