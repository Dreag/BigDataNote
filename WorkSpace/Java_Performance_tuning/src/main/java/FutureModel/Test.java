package FutureModel;

public class Test {
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("������");
		System.out.println("�������");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("����ȡ��ʵ����"+data.getResult());
		
		
	}

}
