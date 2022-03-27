package org.arsal.codegenerator.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class BinarySearchHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		Shell shell = new Shell();				
		
		String myCode = "    int binarySearch(int arr[], int l, int r, int x)\n"
				+ "    {\n"
				+ "        if (r >= l) {\n"
				+ "            int mid = l + (r - l) / 2;\n"
				+ " \n"
				+ "            // If the element is present at the\n"
				+ "            // middle itself\n"
				+ "            if (arr[mid] == x)\n"
				+ "                return mid;\n"
				+ " \n"
				+ "            // If element is smaller than mid, then\n"
				+ "            // it can only be present in left subarray\n"
				+ "            if (arr[mid] > x)\n"
				+ "                return binarySearch(arr, l, mid - 1, x);\n"
				+ " \n"
				+ "            // Else the element can only be present\n"
				+ "            // in right subarray\n"
				+ "            return binarySearch(arr, mid + 1, r, x);\n"
				+ "        }\n"
				+ " \n"
				+ "        // We reach here when element is not present\n"
				+ "        // in array\n"
				+ "        return -1;\n"
				+ "    }";
		StringSelection stringSelection = new StringSelection(myCode);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		MessageDialog.openInformation(shell, "Info", "Your Binary-Search Code has been copy to clipboard");
		
		return null;		
	}
}
