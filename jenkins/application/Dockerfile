FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    openjdk-11-jre-headless \
    python3 \
    python3-pip \
    git \
    curl \
    openssh-client \
    ansible \
    unzip \
    sudo \
    && apt-get clean


RUN pip3 install \
    openshift \
    kubernetes \
    pyyaml \
    jinja2 \
    requests

RUN curl -LO "https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl" \
    && chmod +x kubectl \
    && mv kubectl /usr/local/bin/kubectl
RUN useradd -m -d /home/jenkins -s /bin/bash jenkins \
    && echo "jenkins ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers
USER jenkins
RUN ansible-galaxy collection install kubernetes.core --force

WORKDIR /home/jenkins

CMD ["sleep", "infinity"]