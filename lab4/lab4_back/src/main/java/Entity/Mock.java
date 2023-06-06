package Entity;
import java.util.ArrayList;
import java.util.List;

public class Mock {

	private List<MyEntity> data = new ArrayList<>();
	
	public Mock() {

			this.data.add(new MyEntity(1,"ak-47","made in soviet union", "assets/img/1.jpg"));
			this.data.add(new MyEntity(2, "akm","standart", "assets/img/2.jpg"));
			this.data.add(new MyEntity(3, "acr","good american riffle", "assets/img/3.jpg"));
		}

		public List<MyEntity> getData() {
			return data;
		}

		public void setData(List<MyEntity> data) {
			this.data = data;
		}
	}
