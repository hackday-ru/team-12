import sidePanel from './sidePanel/sidePanel.directive';
import postItem from './posts/postItem/postItem.directive';
import posts from './posts/postsList.directive.js';

angular.module('components', [])
    .directive('sidePanel', (vkDataService, utilsService, toaster, errors) =>
        new sidePanel(vkDataService, utilsService, toaster, errors))
    .directive('postsList', (postsParser, hashtagParser) =>
        new posts(postsParser, hashtagParser))
    .directive('postItem', (hashtagParser) => new postItem(hashtagParser));

