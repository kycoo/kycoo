package com.qfedu.bigweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

public final class CommonUtil {
	
	private static final String allChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private CommonUtil() {
		throw new AssertionError();
	}
	
	public static String generateVC(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			int index = (int) (Math.random() * allChars.length());
			sb.append(allChars.charAt(index));
		}
		return sb.toString();
	}
	
	public static Color randomColor() {
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		return new Color(red, green, blue);
	}
	
	public static BufferedImage getImageFromVC(String vc, int width, int height) {
		BufferedImage vcImage = new BufferedImage(width, height, 1);
		Graphics2D g = (Graphics2D) vcImage.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		int size = (width - 20) / vc.length();
		g.setFont(new Font("Arial", Font.BOLD, height - 4));	
		for (int i = 0; i < vc.length(); ++i) {
			String currentChar = vc.substring(i, i + 1);
			g.setColor(randomColor());
			double theta = (Math.random() * 31 - 15) / 180.0;
			g.rotate(theta);
			g.drawString(currentChar, 10 + i * size, height / 2 + 10);
			g.rotate(-theta);
		}
		for (int i = 0; i < 20; ++i) {
			int x1 = (int) (Math.random() * width);
			int y1 = (int) (Math.random() * height);
			int x2 = (int) (Math.random() * width);
			int y2 = (int) (Math.random() * height);
			g.setColor(randomColor());
			g.drawLine(x1, y1, x2, y2);
		}
		return vcImage;
	}
	
	public static String getFilenameWithoutSuffix(String filename) {
		int pos = filename.lastIndexOf(".");
		return pos > 0 ? filename.substring(0, pos) : filename;
	}
	
	/**
	 * ȡ���ļ����еĺ�׺��
	 * @param filename �ļ���
	 * @return ��׺��
	 */
	public static String getSuffix(String filename) {
		int pos = filename.lastIndexOf(".");
		return pos > 0 && filename.length() > 2 ? filename.substring(pos) : null;
	}
	
	/**
	 * ��û���MD5ժҪ���ļ���
	 * @param input �ļ�������
	 * @param suffix �ļ���׺��
	 * @return MD5ժҪ��ʽ���ļ���
	 * @throws IOException 
	 */
	public static String getMd5Filename(InputStream input, String suffix) throws IOException {
		String md5 = DigestUtils.md5Hex(input);
		return md5 + (suffix != null ? suffix : "");
	}
}
