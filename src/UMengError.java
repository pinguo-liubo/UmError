import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UMengError {
	public static void main(String[] args) {
		String content = getFileContent("C:\\Users\\Frisky\\Desktop\\1.txt");
		Type type = new TypeToken<ErrorInfo>() {
		}.getType();
		ErrorInfo errorInfo = new Gson().fromJson(content, type);

		Map<String, CellInfo> map = new HashMap<String, CellInfo>();
		int count = 0;
		for (CellInfo info : errorInfo.stats) {
			map.put(info.error_type_id, info);
			count++;
		}

		String content2 = getFileContent("C:\\Users\\Frisky\\Desktop\\2.txt");
		ErrorInfo errorInfo2 = new Gson().fromJson(content2, type);
		for (CellInfo info2 : errorInfo2.stats) {
			int errorCount = info2.error_count;
			CellInfo info1 = map.get(info2.error_type_id);
			if (info1 != null) {
				errorCount = errorCount - info1.error_count;
			}
			System.out.println(errorCount + "---------" + info2);
		}

	}

	private static String getFileContent(String path) {
		BufferedReader reader = null;
		try {
			StringBuffer sb = new StringBuffer();
			reader = new BufferedReader(new FileReader(new File(path)));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "{}";
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}
}
