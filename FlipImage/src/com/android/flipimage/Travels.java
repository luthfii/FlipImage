package com.android.flipimage;

import java.util.ArrayList;
import java.util.List;

public class Travels {

	public static final List<Data> IMG_DESCRIPTIONS = new ArrayList<Data>();
	
	static {
			Travels.IMG_DESCRIPTIONS.add(new Travels.Data("new1", "bosch1.jpg"));
			Travels.IMG_DESCRIPTIONS.add(new Travels.Data("new2", "indonesian.jpg"));
			Travels.IMG_DESCRIPTIONS.add(new Travels.Data("new3", "mit wagener 1.jpg"));
		}

	public static final class Data {
		public final String title;
		public final String imageFilename;

		private Data(String title, String imageFilename) {
			this.title = title;
			this.imageFilename = imageFilename;
		}
	}
}
