Feature: Add stress to pitcher

Background:
# TODO: Fill in (make sure you put at least one step here)
Given a Pitcher

Rule: On first call to addStress(int), getStress() returns the amount of stress added.

Scenario: After adding 10 stress to pitcher, getStress returns 10.
# TODO: Fill in
When I add 10 stress to pitcher
Then getStress returns 10

Rule: On subsequent calls to addStress(int), stress is accumulated.

Scenario: After adding 20 stress and then 30 stress to pitcher, getStress returns 50.
# TODO: Fill in
When I add 20 stress to pitcher
Then I add 30 stress to pitcher
Then getStress returns 50