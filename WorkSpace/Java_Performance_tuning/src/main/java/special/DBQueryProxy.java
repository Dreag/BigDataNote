package special;

public class DBQueryProxy implements IDBQuery {
	private DBQuery real = null;

	@Override
	public String request() {
		//������Ҫ��ʱ�� �Ŵ�����ʵ�Ķ���
		if(real==null) {
			real = new DBQuery();
		} else {


		}
		//�ڶ��̵߳Ļ����� ����һ����ٵ���
		return real.request();
	}

}
