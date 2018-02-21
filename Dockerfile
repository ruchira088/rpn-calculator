FROM openjdk:8-jdk

WORKDIR /opt/rpn-calculator
COPY . .

WORKDIR /opt/rpn-calculator/src/main/java
RUN javac com/ruchij/App.java

ENTRYPOINT ["java"]

CMD ["com/ruchij/App"]