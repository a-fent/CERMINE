package pl.edu.icm.coansys.metaextr.metadata.zoneclassification.features;

import pl.edu.icm.coansys.metaextr.classification.features.FeatureCalculator;
import pl.edu.icm.coansys.metaextr.textr.model.BxChunk;
import pl.edu.icm.coansys.metaextr.textr.model.BxLine;
import pl.edu.icm.coansys.metaextr.textr.model.BxPage;
import pl.edu.icm.coansys.metaextr.textr.model.BxWord;
import pl.edu.icm.coansys.metaextr.textr.model.BxZone;

public class WhitespaceRelativeCountLogFeature implements FeatureCalculator<BxZone, BxPage> {
    private static String featureName = "WhitespaceRelativeCountLog";

    @Override
    public String getFeatureName() {
        return featureName;
    }

    @Override
    public double calculateFeatureValue(BxZone zone, BxPage page) {
    	double spaceCount = new WhitespaceCountFeature().calculateFeatureValue(zone, page);
        return -Math.log(spaceCount / (zone.toText().length()) + Double.MIN_VALUE);
    }
}