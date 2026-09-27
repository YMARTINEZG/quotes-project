FROM registry.redhat.io/rhel9/postgresql-13:latest
COPY sql/ /usr/share/container-scripts/postgresql/
