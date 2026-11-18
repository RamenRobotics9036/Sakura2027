# HUGE TODO HERE!

TLDR; This folder is formatted weird. It shouldn't be.
It's also making me consider whether we should talk about
changing our folder and file structure.

Our agreed-upon pattern for formatting subsystems
is that we will have an interface, a sim implementation,
and an implementation for the real bot. We may want
to consider adding a third implementation when we have
the competition bot, but that's a later conversation we
should have as a group. This folder does *not* do this.
The auto-generated code has a different way of creating
the sim class. This seems to reuse a lot of code in
a way that makes sense, and is making me consider whether
we may want to use parent classes rather than interfaces.
But either way, I believe it makes the most sense to
conform this subsystem to the agreed-upon pattern, and
split it into a sim implementation and a real implementation
at a future date (once we have the bot's driving working
correctly).