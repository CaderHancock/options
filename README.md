This is going to be an app to aid me with options trading when "complete" 

Apart from fun and furthering the dream of living off of algo trading, this project is intended to showcase (some level of) technical ability.

current feature set and goals are in progress. this project is a little directionless while i look for a suitable  market data api 
so please don't judge too harshly 


to run

git clone https://github.com/CaderHancock/options.git

cd options/

mvn assembly:assembly

java -jar target/options-0.1-jar-with-dependencies.jar amd190401C00271000 //the passed argument here is a sample
