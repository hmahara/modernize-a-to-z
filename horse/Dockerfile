FROM ubuntu:24.04

# Update packages and install necessary tools

RUN apt-get update && apt-get install -y sudo

# Add a new user 'firas' and create a home directory

RUN useradd -m -s /bin/bash firas

# Grant sudo privileges to the user

RUN echo "firas ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

# Switch to the non-root user
RUN mkdir /app
RUN mkdir /app/horse
COPY target/horse /app/horse
RUN chown -R firas:firas /app/horse
USER firas

# Set the working directory for the user

WORKDIR /app/horse

# Define the default command

CMD ["/app/horse/horse"]
