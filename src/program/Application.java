package program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> votesList = new HashMap<>();
		System.out.print("Enter full file path: ");
		String path = scanner.nextLine();
		scanner.close();

		File votesFile = new File(path);

		try (BufferedReader br = new BufferedReader(new FileReader(votesFile))) {
			String votes = br.readLine();
			while (votes != null) {
				String[] votesData = votes.split(",");
				String candidate = votesData[0];
				int voteCount = Integer.parseInt(votesData[1]);
				if (votesList.containsKey(candidate)) {
					voteCount += votesList.get(candidate);
				}
				votesList.put(candidate, voteCount);
				votes = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error message: " + e);
		}

		for (String key : votesList.keySet()) {
			System.out.println(key + " : " + votesList.get(key));
		}
	}

}
