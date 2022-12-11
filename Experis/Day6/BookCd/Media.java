import java.util.Optional;

// hold data fields of media
public final class Media {
	private final String m_name;
	private final String m_createdBy;
	private boolean m_isOriginal = false;
	private Optional<Long> m_playtimeInMinutes = Optional.empty();

	public Media(final String name, final String createdBy) {		
		this.m_name = name;
		this.m_createdBy = createdBy;
	}

	public Media(final String name, final String createdBy, boolean isOriginal) {		
		this.m_name = name;
		this.m_createdBy = createdBy;
		this.m_isOriginal = isOriginal;
	}

	public Media(final String name, final String createdBy, boolean isOriginal, long playtimeInMinutes) {		
		this.m_name = name;
		this.m_createdBy = createdBy;
		this.m_isOriginal = isOriginal;
		this.m_playtimeInMinutes = Optional.of(playtimeInMinutes);
	}

	public final String getName() {
		return this.m_name;
	}
	
	public final String getName(final String wrapAroundSized) {
		return wrapAroundSized + this.m_name + wrapAroundSized;
	}
	
	public final String getCreatedBy() {
		return this.m_createdBy;
	}

	public final boolean isOriginal() {
		return this.m_isOriginal;
	}

	public final Optional<Long> getPlaytimeInMinutes() {
		return this.m_playtimeInMinutes;
	}
}
