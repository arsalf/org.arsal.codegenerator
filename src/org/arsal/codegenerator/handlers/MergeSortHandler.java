package org.arsal.codegenerator.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class MergeSortHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		Shell shell = new Shell();				
		
		String myCode = "   // Merges two subarrays of arr[].\n"
				+ "    // First subarray is arr[l..m]\n"
				+ "    // Second subarray is arr[m+1..r]\n"
				+ "    void merge(int arr[], int l, int m, int r)\n"
				+ "    {\n"
				+ "        // Find sizes of two subarrays to be merged\n"
				+ "        int n1 = m - l + 1;\n"
				+ "        int n2 = r - m;\n"
				+ "  \n"
				+ "        /* Create temp arrays */\n"
				+ "        int L[] = new int[n1];\n"
				+ "        int R[] = new int[n2];\n"
				+ "  \n"
				+ "        /*Copy data to temp arrays*/\n"
				+ "        for (int i = 0; i < n1; ++i)\n"
				+ "            L[i] = arr[l + i];\n"
				+ "        for (int j = 0; j < n2; ++j)\n"
				+ "            R[j] = arr[m + 1 + j];\n"
				+ "  \n"
				+ "        /* Merge the temp arrays */\n"
				+ "  \n"
				+ "        // Initial indexes of first and second subarrays\n"
				+ "        int i = 0, j = 0;\n"
				+ "  \n"
				+ "        // Initial index of merged subarray array\n"
				+ "        int k = l;\n"
				+ "        while (i < n1 && j < n2) {\n"
				+ "            if (L[i] <= R[j]) {\n"
				+ "                arr[k] = L[i];\n"
				+ "                i++;\n"
				+ "            }\n"
				+ "            else {\n"
				+ "                arr[k] = R[j];\n"
				+ "                j++;\n"
				+ "            }\n"
				+ "            k++;\n"
				+ "        }\n"
				+ "  \n"
				+ "        /* Copy remaining elements of L[] if any */\n"
				+ "        while (i < n1) {\n"
				+ "            arr[k] = L[i];\n"
				+ "            i++;\n"
				+ "            k++;\n"
				+ "        }\n"
				+ "  \n"
				+ "        /* Copy remaining elements of R[] if any */\n"
				+ "        while (j < n2) {\n"
				+ "            arr[k] = R[j];\n"
				+ "            j++;\n"
				+ "            k++;\n"
				+ "        }\n"
				+ "    }\n"
				+ "  \n"
				+ "    // Main function that sorts arr[l..r] using\n"
				+ "    // merge()\n"
				+ "    void sort(int arr[], int l, int r)\n"
				+ "    {\n"
				+ "        if (l < r) {\n"
				+ "            // Find the middle point\n"
				+ "            int m =l+ (r-l)/2;\n"
				+ "  \n"
				+ "            // Sort first and second halves\n"
				+ "            sort(arr, l, m);\n"
				+ "            sort(arr, m + 1, r);\n"
				+ "  \n"
				+ "            // Merge the sorted halves\n"
				+ "            merge(arr, l, m, r);\n"
				+ "        }\n"
				+ "    }";
		StringSelection stringSelection = new StringSelection(myCode);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		MessageDialog.openInformation(shell, "Info", "Your Merge-Sort Code has been copy to clipboard");
		
		return null;		
	}
}
