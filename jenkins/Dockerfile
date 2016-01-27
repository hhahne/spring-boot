FROM jenkins
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
#COPY jobs /var/jenkins_home/jobs
COPY config.xml /var/jenkins_home

USER root
RUN apt-get update
RUN apt-get install sudo
RUN echo "jenkins  ALL=NOPASSWD: ALL" >> /etc/sudoers
USER jenkins

COPY ssh /var/jenkins_home/.ssh
RUN sudo chown -R jenkins:jenkins /var/jenkins_home/.ssh

#RUN chown -R jenkins /var/jenkins_home/.ssh
#RUN chmod -R 600 /var/jenkins_home/
#USER jenkins

#USER root
#ADD /home/developer/.ssh/id_rsa /root/.ssh/id_rsa
#RUN  echo "    IdentityFile ~/.ssh/id_rsa" >> /etc/ssh/ssh_config
