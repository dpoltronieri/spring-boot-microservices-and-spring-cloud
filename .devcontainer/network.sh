#!/bin/bash

network_name="internal-network"

if ! docker network inspect "$network_name" >/dev/null 2>&1; then
    docker network create "$network_name"
    echo "Network '$network_name' created successfully."
else
    echo "Network '$network_name' already exists."
fi