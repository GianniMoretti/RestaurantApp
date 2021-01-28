package DomainModel;

import java.util.ArrayList;
import java.util.Date;

public class FakeTableRecord implements RepositoryTableRecord{
	
	private ArrayList<TableServiceRecord> records;
	
	public FakeTableRecord() {
		records= new ArrayList<TableServiceRecord>();
	}

	@Override
	public void addRecord(TableServiceRecord tsr) {
		records.add(tsr);
	}

	@Override
	public ArrayList<TableServiceRecord> getRecords(Date date) {
		ArrayList<TableServiceRecord> tmp= new ArrayList<TableServiceRecord>();
		for(TableServiceRecord record: records) {
			if(record.getDate()==date)
				tmp.add(record);	
		}
		return tmp;
	}

	@Override
	public boolean deleteRecords(Date date) {
		ArrayList<TableServiceRecord> tmp= new ArrayList<TableServiceRecord>();
		for(TableServiceRecord record: records) {
			if(record.getDate()==date){
				tmp.add(record);
			}
		}
		return records.removeAll(tmp);
	}

}
