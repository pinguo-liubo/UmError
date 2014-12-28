public class CellInfo {
	String subtitle;
	int error_count;
	String error_type_id;
	String title;
	String created_at;
	String updated_at;
	Tag[] tags;
	String app_version;
	String formatted_created_at;
	
	@Override
	public String toString() {
		return "CellInfo [error_count=" + error_count + ", title=" + title
				+ ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}

	
}
