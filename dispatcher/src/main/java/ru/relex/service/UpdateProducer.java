package ru.relex.service;

import org.telegram.telegrambots.meta.api.objects.Update;
//передаёт апдейты в rabbitmq
public interface UpdateProducer {
    void produce(String rabbitQueue, Update update);
}
