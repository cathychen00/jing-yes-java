package org.jingyes.designpattern.Behavioral.mediator.uidemo;

/**
 * @author jingyes
 * @date 2023/12/14
 */
public class ConcreteMediator extends Mediator{
    public Button button;
    public List list;
    public TextBox textBox;
    @Override
    public void onComponentChanged(Component component) {
        if(button==component){
            System.out.println("点击按钮");
            list.update();
            textBox.update();
        }else if(list==component){
            System.out.println("选择列表");
            list.update();
            textBox.update();
        }else if(component==textBox){
            System.out.println("文本框输出");
            textBox.update();
        }
    }
}
