int red = (int)(Math.random() * 128 + 127); // 127 is quite dark dont use lower value
int green = (int)(Math.random() * 128 + 127);
int blue = (int)(Math.random() * 128 + 127);

//creating random opaque RGB color
int color = 0xff << 24 | (red << 16) | (green << 8) | blue;

//view.setBackgroundColor(color)