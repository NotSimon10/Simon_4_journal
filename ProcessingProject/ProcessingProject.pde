void setup() {
  size(800, 800);
}

void draw() {
  if (mousePressed) {
    fill(0);
     
  } else {
   if ((mouseX+mouseY)%2==0){
    fill(255,0,0,180);
  } else{
    fill(0,0,255,180);}
  ellipse(mouseX, mouseY, 80, 80);
}

}