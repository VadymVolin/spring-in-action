package fuddlang.fuddpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class Fuddifier implements BeanPostProcessor {

    /**
     * arg
     * bean Object
     * beanName String
     * <p>
     * call before init-method
     * don't do anything
     */

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * arg
     * bean Object
     * beanName String
     * <p>
     * method call after initialization component
     * and convert all string property of component to fudd lang
     * <p>
     * use setAccessible method to take hide property
     */

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getType().equals(String.class)) {
                    fields[i].setAccessible(true);
                    String original = fields[i].get(bean).toString();
                    fields[i].set(bean, fuddify(original));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;

    }

    //    replace symbol in string
    private String fuddify(String original) {
        if (original == null) return original;
        return original.replaceAll("(r|l)", "w").replaceAll("(R|L)", "W");
    }
}
