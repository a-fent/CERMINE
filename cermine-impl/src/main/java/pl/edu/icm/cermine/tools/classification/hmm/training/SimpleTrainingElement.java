package pl.edu.icm.cermine.tools.classification.hmm.training;

import pl.edu.icm.cermine.tools.classification.features.FeatureVector;

/**
 * Simple classifier training element implementation.
 *
 * @author Dominika Tkaczyk (dtkaczyk@icm.edu.pl)
 */
public class SimpleTrainingElement<S> implements TrainingElement<S> {

    private FeatureVector observation;
    private S label;
    private S nextLabel;
    private boolean first;


    public SimpleTrainingElement(FeatureVector observation, S label, boolean first) {
        this.observation = observation;
        this.label = label;
        this.first = first;
    }

    public void setNextLabel(S nextLabel) {
        this.nextLabel = nextLabel;
    }

    @Override
    public FeatureVector getObservation() {
        return observation;
    }

    @Override
    public boolean isFirst() {
        return first;
    }

    @Override
    public S getLabel() {
        return label;
    }

    @Override
    public S getNextLabel() {
        return nextLabel;
    }
    
    @Override
    public SimpleTrainingElement<S> clone() {
        try {
            SimpleTrainingElement<S> element = (SimpleTrainingElement) super.clone();
            element.first = first;
            element.label = label;
            element.nextLabel = nextLabel;
            element.observation = observation.clone();
            return element;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

	@Override
	public void setLabel(S label) {
		this.label = label;
	}

}
