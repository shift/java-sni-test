FROM java:6-jdk

ADD HTTPSClient.java /
RUN javac /HTTPSClient.java

