package org.jingyes.designpattern.Behavioral.mediator.uidemo;

/**
 * @author 陈敬
 * @date 2023/12/14
 */
public abstract class Component {
    private ConcreteMediator mediator;

    public void setMediator(ConcreteMediator mediator) {
        this.mediator = mediator;
    }

    public void change(){
        this.mediator.onComponentChanged(this);
    }

    public abstract void update();
}
