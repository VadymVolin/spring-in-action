package counterBeans;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanCounter implements BeanFactoryPostProcessor {

    private Logger LOGGER = Logger.getLogger(BeanCounter.class);

    /**
     * write count of load components
     */

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        LOGGER.debug
        System.out.println("BEAN COUNT: " + beanFactory.getBeanDefinitionCount());
    }

}
