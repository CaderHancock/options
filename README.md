This is going to be an app to aid me with options trading when "complete" 

Apart from fun and furthering the dream of living off of algo trading, this project is intended to showcase (some level of) technical ability.

Current milestones

  flesh out functions
  
  catch all lazily thrown exceptions
  
  implement most of current design doc
  
 
  Stock paper trading
  
  financial derivitive + formula objects
  
  find decent, free, easy to implement derivitives data api (Actually kinda hard)
  
  derivitives paper trading
  
  algo trading engine
  
  brokerage account integration
  
  
  
also, i like to use a script that pulls commit messages from whatthecommit.com to keep me entertained while working
so please don't judge too harshly 
"meaningful" commit messages are in ALLCAPS

to run

git clone https://github.com/CaderHancock/options.git

cd options/

mvn assembly:assembly

java -jar target/options-0.1-jar-with-dependencies.jar
