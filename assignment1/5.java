package adnan;

import java.io.File;
import java.io.IOException;

public class recursiveFileTreeLister implements IFileTreeLister {

	// This is the utility function to implement our recursive logic.
	private static void recursiveList(File[] arr, int index) {
		// If the array containing file list is already at level index, we dont need to continue
		if(index == arr.length) 
            return; 
		
		// Check if the element at index in array is file or directory
		if(arr[index].isFile()) {
			// If it is file, simply print it.
            System.out.println(arr[index].getName());
		} else if(arr[index].isDirectory()) {
			// If it is a directory, first print the directory name
			System.out.println("File from directory: "+arr[index].getName());
			// Now, we call our function recursively for this sub-directory with starting index at 0
			recursiveList(arr[index].listFiles(),0);
		}
		// Once we process element at this index, we move on to next index element and recursively call our function
		recursiveList(arr, ++index);
		
	}
	
	@Override
	public void list(String path) throws IOException {
		// TODO Auto-generated method stub
		// First we find the main directory from the given path
		File maindir = new File(path);
		// Check if path provided exists and is a directory.
		// if it is not a directory, we can simply print the name as it is a file
		if (maindir.exists() && maindir.isDirectory()) {
			// Store all the files/directories inside an array.
			File arr[] = maindir.listFiles();
			System.out.println("File from directory: "+maindir.getName());
			// Call our utility function starting with this main directory.
			recursiveList(arr, 0);
		} else if (maindir.exists() && maindir.isFile()) {
			// if main directory was a file, simply print
			System.out.println(maindir.getName());
		}
	}

}
