package demo.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import demo.io.InitialFileIO;
import demo.model.Data;

public class Main {
	public static void main(String args[]) {
		InitialFileIO fileio = new InitialFileIO();
		String inputPath = "/Users/bju/Documents/output.txt";
		
		ArrayList<Data> dataList = new ArrayList<Data>();

		try {
			File file = new File(inputPath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			int countOfLine = -1;

			while ((line = bufferedReader.readLine()) != null) {
				String flag = "";
				int indexOfComma = 0;
				int previousCommaIndex = 0;
				Data data = new Data();
				countOfLine++;
				char[] lineCharArray = line.toCharArray();
				for (int i = 0; i < lineCharArray.length; i++) {
					if (lineCharArray[i] == ',') {
						switch (flag) {
						case "GPS":
							data.setGps_location(line.substring(previousCommaIndex + 1, i));
							break;
						case "LBS":
							data.setLbs_location(line.substring(previousCommaIndex + 1, i));
							break;
						case "STT":
							data.setStt_data(line.substring(previousCommaIndex + 1, i));
							break;
						case "MGR":
							data.setMgr_data(line.substring(previousCommaIndex + 1, i));
							break;
						case "ADC":
							data.setAdc_data(line.substring(previousCommaIndex + 1, i));
							break;
						case "OBD":
							data.setObc_data(line.substring(previousCommaIndex + 1, i));
							break;
						case "FUL":
							data.setFul_data(line.substring(previousCommaIndex + 1, i));
							break;
						case "OAL":
							break;
						case "HDB":
							break;
						default:
							break;
						}

						if (indexOfComma == 1) { // IMEI
							data.setDevice_imei(line.substring(previousCommaIndex + 1, i));
						} else if (indexOfComma == 2) { // Time
							data.setCurrent_time(line.substring(previousCommaIndex + 1, i));
						} else {
							switch (line.substring(i + 1, i + 4)) {
							case "GPS":
								flag = "GPS";
								break;
							case "LBS":
								flag = "LBS";
								break;
							case "STT":
								flag = "STT";
								break;
							case "MGR":
								flag = "MGR";
								break;
							case "ADC":
								flag = "ADC";
								break;
							case "OBD":
								flag = "OBD";
								break;
							case "FUL":
								flag = "FUL";
								break;
							case "EVT":
								data.setEvt_data(line.substring(i + 1, lineCharArray.length));
								break;
							case "OAL":
								flag = "OAL";
								break;
							case "HDB":
								flag = "HDB";
								break;
							default:
								flag = "";
								break;
							}
						}
						previousCommaIndex = i;
					}
				}
				dataList.add(data);
			}

//			for (int i = 0; i < dataList.size(); i++) {
//				System.out.println("GPS : " + dataList.get(i).getGps_location());
//				System.out.println("LBS : " + dataList.get(i).getLbs_location());
//				System.out.println("STT : " + dataList.get(i).getStt_data());
//				System.out.println("MGR : " + dataList.get(i).getMgr_data());
//				System.out.println("ADC : " + dataList.get(i).getAdc_data());
//				System.out.println("OBD : " + dataList.get(i).getObd_data());
//				System.out.println("FUL : " + dataList.get(i).getFul_data());
//				System.out.println("EVT : " + dataList.get(i).getEvt_data());
//			}

			System.out.println(dataList.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
