#!/usr/bin/env bash

GIT_TAG=$(git describe --abbrev=0)

apibuilder upload stakeboard stakeboard-labels-lib .apibuilder/stakeboard-labels-lib.json --version ${GIT_TAG}
