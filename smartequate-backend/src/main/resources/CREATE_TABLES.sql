-- CREAR LES NOVES TAULES

CREATE TABLE size (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	length FLOAT NOT NULL,
  	width FLOAT NOT NULL,
  	height FLOAT NOT NULL
);

CREATE TABLE sensors (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	accelerometer BOOLEAN NOT NULL,
	gyroscope BOOLEAN NOT NULL,
	magnetometer BOOLEAN NOT NULL,
	gps BOOLEAN NOT NULL,
	proximity BOOLEAN NOT NULL,
	light BOOLEAN NOT NULL,
	fingerprint BOOLEAN NOT NULL,
	barometer BOOLEAN NOT NULL,
	thermometer BOOLEAN NOT NULL
);

CREATE TABLE resolution (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	width INTEGER NOT NULL,
  	height INTEGER NOT NULL
);

CREATE TABLE averages (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	average_height FLOAT NOT NULL,
  	average_weight FLOAT NOT NULL,
  	average_display_size FLOAT NOT NULL,
  	average_camera_a FLOAT NOT NULL,
  	average_camera_b FLOAT NOT NULL,
  	average_rom FLOAT NOT NULL,
  	average_ram FLOAT NOT NULL,
  	average_resolution_width FLOAT NOT NULL,
  	average_resolution_height FLOAT NOT NULL,
  	average_battery FLOAT NOT NULL,
  	last BOOLEAN NOT NULL
);
 
CREATE TABLE attributes (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	weight FLOAT NOT NULL,
 	sim_tray INTEGER NOT NULL,
 	cpu VARCHAR(250) NOT NULL,
 	display_size FLOAT NOT NULL,
 	card_slot BOOLEAN NOT NULL,
 	camera_a INTEGER NOT NULL,
 	camera_b INTEGER NOT NULL,
 	jack BOOLEAN NOT NULL,
 	rom INTEGER NOT NULL,
 	ram INTEGER NOT NULL,
 	battery INTEGER NOT NULL,
 	multitouch BOOLEAN(250) NOT NULL,
 	size_id INTEGER,
  	foreign key (size_id) references size(id),
  	sensors_id INTEGER,
  	foreign key (sensors_id) references sensors(id),
  	resolution_id INTEGER,
  	foreign key (resolution_id) references resolution(id),
  	port VARCHAR(250) NOT NULL,
  	display_type VARCHAR(250) NOT NULL
);

CREATE TABLE points (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	height_points FLOAT NOT NULL,
  	weight_points FLOAT NOT NULL,
  	sim_tray_points FLOAT NOT NULL,
  	cpu_points FLOAT NOT NULL,
  	display_size_points FLOAT NOT NULL,
  	card_slot_points FLOAT NOT NULL,
  	cameraapoints FLOAT NOT NULL,
  	camerabpoints FLOAT NOT NULL,
  	jack_points FLOAT NOT NULL,
  	display_type_points FLOAT NOT NULL,
  	rom_points FLOAT NOT NULL,
  	ram_points FLOAT NOT NULL,
  	resolution_points FLOAT NOT NULL,
  	battery_points FLOAT NOT NULL,
  	sensors_gyroscope_points FLOAT NOT NULL,
  	sensors_magnetometer_points FLOAT NOT NULL,
  	sensors_gps_points FLOAT NOT NULL,
  	sensors_proximity_points FLOAT NOT NULL,
  	sensors_light_points FLOAT NOT NULL,
  	sensors_fingerprint_points FLOAT NOT NULL,
  	sensors_barometer_points FLOAT NOT NULL,
  	sensors_thermometer_points FLOAT NOT NULL,
  	sensors_accelerometer_points FLOAT NOT NULL,
  	port_points FLOAT NOT NULL,
  	multitouch_points FLOAT NOT NULL,
  	total_points FLOAT NOT NULL
);

CREATE TABLE user (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	username VARCHAR(250) NOT NULL,
  	password VARCHAR(250) NOT NULL,
  	role VARCHAR(250) NOT NULL
);

CREATE TABLE phone (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	name VARCHAR(250) NOT NULL,
  	attributes_id INTEGER,
  	foreign key (attributes_id) references attributes(id),
  	brand VARCHAR(250) NOT NULL,
  	points_id INTEGER,
  	foreign key (points_id) references points(id)
);

CREATE TABLE vote (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	user_id INTEGER,
  	foreign key (user_id) references user(id),
  	phone_id INTEGER,
  	foreign key (phone_id) references phone(id)
);









