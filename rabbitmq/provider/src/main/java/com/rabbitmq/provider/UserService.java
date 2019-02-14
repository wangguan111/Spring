package com.rabbitmq.provider;

import com.rabbitmq.common.ExchangeEnum;
import com.rabbitmq.common.QueueEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(rollbackFor = Exception.class)
public class UserService {
//    @Autowired
//    private UserRepository userRepository;
    /**
     * 消息队列业务逻辑实现
     */
    @Autowired
    private QueueMessageService queueMessageService;

    private Long id = 1L;
    /**
     * 保存用户
     * 并写入消息队列
     *
     * @param userEntity
     * @return
     */
    public Long save(UserEntity userEntity) throws Exception {
        /**
         * 保存用户
         */
//        userRepository.save(userEntity);
        if(userEntity.getId() == null)
        {
            userEntity.setId(id);
            id++;
        }

        /**
         * 将消息写入消息队列
         */
        queueMessageService.send(userEntity.getId(), ExchangeEnum.USER_REGISTER, QueueEnum.USER_REGISTER);

        return userEntity.getId();
    }
}
