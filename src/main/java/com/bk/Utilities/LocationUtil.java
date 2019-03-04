package com.bk.Utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 *
 */
public class LocationUtil {

	public static double getDistance(double lat1, double lon1, double lat2, double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

	public static Map<String, Object> getCurrentLatutitudeAndlongititue() {
		// we in future will add dynamic location logic
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LAT", -1.970970);
		map.put("LOG", -1.970970);

		return map;
	}

	public static double getLat() {

		return -1.970970;
	}

	public static double getLog() {

		return 30.110868;
	}

	public static void main(String[] args) {
		System.out.println(getDistance(-1.971657, 30.102971, -2.020722, 30.114299, 'K') + " Km\n");
		System.out.println(getDistance(-1.971657, 30.102971, -1.989842, 30.107436, 'K') + " Km\n");

	}
	
}
