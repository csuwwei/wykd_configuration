package com.pri;

import org.dromara.hmily.annotation.Hmily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RemoteUserService remoteUserService;

    @Transactional
    @Hmily(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public String createOrder(Order order) throws Exception{
        orderDao.save(order);
        remoteUserService.tryPayment(order.getId());
        logger.info("创建订单");
        
        if("1001".equals(order.getId())) {
        	throw new Exception();
        }
        
        return order.getId();
    }

    public void confirmOrder(Order order){
        order.setStatus("1");
        orderDao.save(order);
        logger.info("确认订单");
        System.out.println("确认订单");
    }

    public void cancelOrder(Order order){
        order.setStatus("2");
        orderDao.save(order);
        logger.info("取消订单");
        System.out.println("取消订单");
    }

}
