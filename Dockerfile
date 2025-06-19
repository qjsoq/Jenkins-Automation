FROM jenkins/jenkins:2.452.1-lts

RUN jenkins-plugin-cli --plugins \
    kubernetes:4353.vb_47977da_9417 \
    workflow-job:1520.v56d65e3b_4566 \
    job-dsl:1.92 \
    configuration-as-code:1775.v810dc950b_514 \
    git:5.7.0 \
    workflow-aggregator:608.v67378e9d3db_1
