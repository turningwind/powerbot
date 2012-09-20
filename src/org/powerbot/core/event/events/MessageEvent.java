package org.powerbot.core.event.events;

import java.util.EventListener;

import org.powerbot.core.event.EventMulticaster;
import org.powerbot.core.event.GameEvent;
import org.powerbot.core.event.listeners.MessageListener;

/**
 * A message event that is dispatched when a new message is dispatched in the game.
 *
 * @author Timer
 */
public class MessageEvent extends GameEvent {
	private static final long serialVersionUID = 1L;
	private final int id;
	private final String sender, message;

	public MessageEvent(final int id, final String sender, final String message) {
		setType(EventMulticaster.MESSAGE_EVENT);
		this.id = id;
		this.sender = sender;
		this.message = message;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispatch(final EventListener eventListener) {
		((MessageListener) eventListener).messageReceived(this);
	}

	/**
	 * @return The Id of this message (type).
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return The name of the sender of this message.
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @return The contents of this message.
	 */
	public String getMessage() {
		return message;
	}
}
