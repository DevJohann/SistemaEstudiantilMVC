package co.edu.unbosque.sistemamestmejorado;
import java.util.ArrayList;

public class SystemController {
	
	UserView Vista = new UserView();
	//SystemModel model = new SystemModel(); It will not going to be just one model
	ArrayList<SystemModel> modelArray = new ArrayList<SystemModel>(); //This should be here?
	
	public int startApp() {
		int mainMenuRetorno = Vista.mainMenu();
		return mainMenuRetorno;
	}
	
	public void responseSelection(int value) {
		
		switch(value) {
		case 1:
			addStudent();
			break;
		case 2:
			ArrayList<String> returnedData = getStudentData();
			if(returnedData.size() == 0) {
				//Vista.notFound();
				break;
			}
			else {
				Vista.ok();
				Vista.showStudentDetails(returnedData.get(0), returnedData.get(1), returnedData.get(2));
				break;
			}
		case 3:
			deleteStudent();
			break;
		case 4:
			modifyData();
			break;
		case 5:
			getAllStudents();
			break;
		default:
			System.out.println("System error");
			break;
		}
	}
	
	public void addStudent() {
		ArrayList<String> gatheredData = Vista.addStudentGathering();
		modelArray.add(new SystemModel(gatheredData.get(0), gatheredData.get(1), gatheredData.get(2)));
		Vista.ok();
	}
	
	public ArrayList<String> getStudentData() {
		String target = Vista.getStudentDataGathering();
		ArrayList<String> gatheredData = new ArrayList<String>();
		for(SystemModel model : modelArray) {
			if(model.getName().toLowerCase().equals(target.toLowerCase())) {
				gatheredData.add(model.getName());
				gatheredData.add(model.getAge());
				gatheredData.add(model.getYear());
			}
		}
		if(gatheredData.size() == 0) {
			Vista.notFound();
		}
		return gatheredData;
	}
	
	public void deleteStudent() {
		String target = Vista.getStudentDataGathering();
		for(SystemModel model : modelArray) {
			if(model.getName().toLowerCase().equals(target.toLowerCase())) {
				Vista.ok();
				modelArray.remove(model);
			}
		}
	}
	public void modifyData() {
		String target = Vista.getStudentDataGathering();
		for(SystemModel model : modelArray) {
			if(model.getName().toLowerCase().equals(target.toLowerCase())) {
				int responseIndex = Vista.showModifyMenu();
				String dataToModify = Vista.compareResponseModify(responseIndex);
				if(responseIndex == 0) {
					break;
				}
				else {
					switch(responseIndex) {
					case 1:
						model.setName(dataToModify);
						Vista.ok();
						break;
					case 2:
						model.setAge(dataToModify);
						Vista.ok();
						break;
					case 3: 
						model.setYear(dataToModify);
						Vista.ok();
						break;
					}
				}
			}
		}
		
	}
	
	
	public void getAllStudents() {
		Vista.ok();
		Vista.showAllStudents(modelArray);
	}
	
}
