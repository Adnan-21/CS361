package adnan;

import java.io.File;
import java.io.IOException;

public class iterativeFileTreeLister implements IFileTreeLister {

	@Override
	public void list(String path) throws IOException {
		// TODO Auto-generated method stub
		
		//First we find the main directory from the given path
		File maindir = new File(path);
		
		// Check if path provided exists and is a directory.
		// if it is not a directory, we can simply print the name as it is a file
		if (maindir.exists() && maindir.isDirectory()) {
			// Store all the files/directories inside an array.
			File arr[] = maindir.listFiles();
			
			int i = 0;
			// We will traverse this array and process each file/directory one by one
			while (i < arr.length) {
				// If it is a file, simply print it or else go inside the directory and find files inside sub-directory
				if(arr[i].isFile()) {
					System.out.println(arr[i].getName());
				} else if(arr[i].isDirectory()) {
					System.out.println("Files from directory: " + arr[i].getName());
					// We first fetch all the files in this sub-directory and store it in the array.
					File []arr_sub = arr[i].listFiles();
					// We then traverse through all the files inside this sub array and print one by one.
					for (int j = 0; j<arr_sub.length; j++) {
						System.out.println(arr[i].getName());
					}
				}
				i++;
			}
		} else if (maindir.exists() && maindir.isFile()) {
			// if main directory was a file, simply print
			System.out.println(maindir.getName());
		}
	}
}


