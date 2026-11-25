# Constants are weird.

Currently, the codebase is formatted as though we only
have two configurations, Waffle and Sim, which share
all of their basic hardware information. When we add
the competition bot, we'll probably want to move CAN
ids etc. to the top of the file of their respective
configuration, or ensure they're exactly the same
on both robots.