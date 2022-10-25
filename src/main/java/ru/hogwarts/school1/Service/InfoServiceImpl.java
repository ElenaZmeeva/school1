package ru.hogwarts.school1.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    private final Logger logger= LoggerFactory.getLogger(InfoServiceImpl.class);

    @Value("${server.port}")
    private Integer serverPort;

    @Override
    public Integer getServerPort() {
        logger.debug("Requesting server port");
        return serverPort;
    }
}
