package observation;

public class ConcreteObserver implements IObserver {

	@Override
	public void update(int state) {
		System.out.println("���Ѿ��۲쵽"+state+"������ʾ���5");
	}
    
}
