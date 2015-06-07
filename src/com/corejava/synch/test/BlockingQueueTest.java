package com.corejava.synch.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("please input the base directory");
		String directory = in.nextLine();
		System.out.println("please enter keyword(e.g volatile)");
		String keyword = in.nextLine();
		final int FILE_QUEUE_SIZE = 10;
		final int SEARCH_THREADS = 100;

		BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

		FileEumerationTask enumerator = new FileEumerationTask(queue, new File(
				directory));
		new Thread(enumerator).start();
		for (int i = 1; i < SEARCH_THREADS; i++) {
			new Thread(new SearchTask(queue, keyword)).start();
		}

	}

}

class FileEumerationTask implements Runnable {
	public static File DUMMY = new File("");// only one instance
	private BlockingQueue<File> queue;
	private File startingDirectory;

	public FileEumerationTask(BlockingQueue<File> queue, File startingDirectory) {
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}

	public void run() {
		try {
			enumerate(startingDirectory);
			queue.put(DUMMY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void enumerate(File directory) throws InterruptedException {
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				enumerate(file);
			else
				queue.put(file);
		}
	}

}

class SearchTask implements Runnable {

	private BlockingQueue<File> queue;
	private String keyword;

	public SearchTask(BlockingQueue<File> queue, String keyword) {
		this.queue = queue;
		this.keyword = keyword;
	}

	/*
	 * search the key word in the file;
	 */
	@Override
	public void run() {

		try {
			boolean done = false;
			while (!done) {
				File file = queue.take();
				if (file == FileEumerationTask.DUMMY) {
					queue.put(file);
					done = true;
				} else
					search(file);
			}
			File file = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void search(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		int lineNumber = 0;
		while (in.hasNextLine()) {
			lineNumber++;
			String line = in.nextLine();
			if (line.contains(keyword)) {
				System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber,
						line);
			}
		}
	}

}