package org.jingyes.j2se.innerclass.sequence;

/**
 * @author 陈敬
 * @date 2024/6/13
 */
public class Main {
    public static void main(String[] args) {
        Sequence sequence=new Sequence(10);
        for(int i=0;i<10;i++){
            sequence.addObject("item"+i);
        }

        Selector selector=sequence.selector();
        iterateSelector(selector);

        Selector reverseSelector=sequence.reverseSelector();
        iterateSelector(reverseSelector);
    }

    private static void iterateSelector(Selector selector){
        while (!selector.end()){
            System.out.println(selector.current().toString());
            selector.next();
        }
        System.out.println("**DONE!!**");
    }
}
