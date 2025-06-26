FROM jenkins/jenkins:2.452.3

RUN jenkins-plugin-cli --plugins \
    kubernetes:4151.v6fa_f0fb_0b_4c9 \
    workflow-job:1400.v7fd111b_ec82f \
    job-dsl:1.87 \
    configuration-as-code:1836.vccda_4a_122a_a_e \
    git:5.2.1 \
    workflow-aggregator:596.v8c21c963d92d \
    generic-webhook-trigger:1.88.0