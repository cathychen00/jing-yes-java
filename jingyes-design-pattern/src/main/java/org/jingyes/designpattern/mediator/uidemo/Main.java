package org.jingyes.designpattern.mediator.uidemo;

/**
 * @author 陈敬
 * @date 2023/12/14
 */
public class Main {
    public static void main(String[] args) {
        Button button=new Button();
        List list=new List();
        TextBox textBox=new TextBox();

        ConcreteMediator mediator=new ConcreteMediator();
        mediator.button=button;
        mediator.list=list;
        mediator.textBox=textBox;

        button.setMediator(mediator);
        list.setMediator(mediator);
        textBox.setMediator(mediator);

        button.change();
        list.change();;
    }
}
